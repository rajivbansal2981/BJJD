package com.jmk.bjjd.web.utils;

import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.DocumentException;


public interface PdfCreator<T> {

	void createPdf(String destination,List<T> list) throws  FileNotFoundException, DocumentException;
	
}
