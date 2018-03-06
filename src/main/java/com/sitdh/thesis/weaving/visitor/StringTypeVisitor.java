package com.sitdh.thesis.weaving.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.sitdh.thesis.weaving.db.entity.File;
import com.sitdh.thesis.weaving.db.entity.PropertyStore;
import com.sitdh.thesis.weaving.db.repository.PropertyStoreRepository;

@Component
public class StringTypeVisitor extends VoidVisitorAdapter<String> {
	
	@Autowired
	private PropertyStoreRepository propertyStoreRepository;
	
	public void visiter(PrimitiveType primitiveType, String message) {
		
		PropertyStore property = new PropertyStore();
		
		
		property.setType("String");
		property.setValue(message);
		
		propertyStoreRepository.save(property);	
	}

}
