package com.moloucars.moloucars.Service;

import com.moloucars.moloucars.Model.ObjetoArray;

public abstract class OBService {

	abstract ObjetoArray findByNomeContainingIgnoreCase(String nome);

	
}
