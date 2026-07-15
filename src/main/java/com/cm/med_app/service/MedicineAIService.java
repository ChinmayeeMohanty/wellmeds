package com.cm.med_app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.cm.med_app.model.Product;
import com.cm.med_app.repository.ProductRepository;

@Service
public class MedicineAIService {

  private final ChatClient chatClient;
  private final ProductRepository productRepository;
   
  public MedicineAIService(ChatClient.Builder builder,
                           ProductRepository productRepository) {

      this.chatClient = builder.build();
      this.productRepository = productRepository;
  }
 
   public String recommendMedicine(String query)
   {
	   List<Product> medicines= productRepository.findAll();
	  String medicineData=medicines.stream().map(m->m.getName()+" ₹"+m.getPrice()).collect(Collectors.joining("\n"));
	  String prompt = """
			  You are a smart pharmacy assistant.

			  User Query:
			  %s

			  Available Medicines:
			  %s

			  Your task:

			  - Understand the user's symptoms or requirement.
			  - Recommend ONLY ONE best medicine from the available medicines.
			  - If no suitable medicine is available, politely say so.

			  Response Format:

			  Medicine Recommendation

			  Medicine Name: <medicine name>

			  Price: ₹<price>

			  Reason: <Explain in one or two short sentences why this medicine is suitable.>


			  Rules:

			  - The medicine recommendation must always come first.
			  - Use only the medicines from the available medicines list.
			  - Do not invent medicines or prices.
			  - Keep the response concise.
			  - Do not use Markdown.
			  - Do not use #, *, **, bullet points, or numbering.
			  - Return plain text only.
			  """.formatted(query, medicineData);
	   return chatClient.prompt(prompt).call().content() ;
   }
   
 
   
}
