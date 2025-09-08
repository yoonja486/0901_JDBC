package com.kh.operation.run;

import com.kh.common.JDBCTemplate;
import com.kh.operation.view.OperationView;

public class OperationRun {

	public static void main(String[] args) {
		
		
		JDBCTemplate.registDriver();
		new OperationView().mainMenu();

	}

}
