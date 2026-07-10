package com.cm.med_app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.med_app.model.Medicine;
import com.cm.med_app.repository.MedicineRepo;

@Service
public class MedicineAIService {

  private final ChatClient chatClient;
  private final MedicineRepo medicineRepository;
   
  public MedicineAIService(ChatClient.Builder builder,
                           MedicineRepo medicineRepository) {

      this.chatClient = builder.build();
      this.medicineRepository = medicineRepository;
  }
 
   public String recommendMedicine(String query)
   {
	   List<Medicine> medicines= medicineRepository.findAll();
	   String medicineData=medicines.stream().map(m->m.getName()+" ₹"+m.getPrice()).collect(Collectors.joining("\n"));
	   String prompt="""
	   		you are a smart pharmacy assistant.
	   		user requirement:
	   		%s
	   		available medicines:
	   		%s
	   		task:
	   		recommend the best medicines based on price and suitability.
	   		keep answers short and useful.
	   		Give me funny jokes related to %s
	   		""".formatted(query,medicineData,query);
	   return chatClient.prompt(prompt).call().content() ;
   }
   
 
   
}
