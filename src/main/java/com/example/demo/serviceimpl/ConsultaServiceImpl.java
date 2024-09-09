package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ConsultaDao;
import com.example.demo.entity.Consulta;
import com.example.demo.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService{
	@Autowired
	private ConsultaDao consultaDao;
	@Override
	public Consulta create(Consulta c) {
		// TODO Auto-generated method stub
		return consultaDao.create(c);
	}

	@Override
	public Consulta update(Consulta c) {
		// TODO Auto-generated method stub
		return consultaDao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		consultaDao.delete(id);
	}

	@Override
	public Optional<Consulta> read(Long id) {
		// TODO Auto-generated method stub
		return consultaDao.read(id);
	}

	@Override
	public List<Consulta> readAll() {
		// TODO Auto-generated method stub
		return consultaDao.readAll();
	}
	
}
