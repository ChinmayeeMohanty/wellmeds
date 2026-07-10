package com.cm.med_app.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

@RestController
public class PaymentController {
	
	@Value("${razorpay.key_id}")
	private String KEY_ID;
	@Value("${razorpay.key_secret}")
	private String KEY_SECRET;
	
	@PostMapping("/create-order")
	public String createOrder(@RequestParam("amount") double amount) throws RazorpayException
	{
		 System.out.println("Received Amount = " + amount);
		RazorpayClient razorpay= new RazorpayClient(KEY_ID,KEY_SECRET);
		JSONObject orderRequest=new JSONObject();
		orderRequest.put("amount", (int) amount*100);
		orderRequest.put("currency","INR");
		Order order=razorpay.orders.create(orderRequest);
		return order.toString();
	}
	
	@PostMapping("/payment-callback")
	public ResponseEntity<String> paymentCallback(
		@RequestParam("razorpay_order_id") String razorpayOrderId,
		@RequestParam("razorpay_payment_id") String razorpayPaymentId,
		@RequestParam("razorpay_signature") String razorpaySignature
		) throws RazorpayException 
	{
		try
		{
			String signature=razorpayOrderId+"|"+razorpayPaymentId;
			boolean isValid=Utils.verifySignature(razorpaySignature, signature,KEY_SECRET);	
			if(isValid)
			{
				return ResponseEntity.ok("Payment Verified");
				
			}
			else
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Signature Invalid");
			}
		}
		
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error"+e.getMessage());
			
		}
	}
	
	@RequestMapping("/get-key")
	public String getKey()
	{
		return KEY_ID;
	}

}
