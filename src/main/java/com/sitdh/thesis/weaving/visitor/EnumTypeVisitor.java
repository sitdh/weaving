package com.sitdh.thesis.weaving.visitor;

import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class EnumTypeVisitor extends VoidVisitorAdapter<Enum<?>>  {

	public void visiter(PrimitiveType primitiveType, String message) {
		
	}
}
