package com.care.root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //데이터를 return하는 controller (보통 컨트롤러는 jsp 페이지를 리턴함)
public class TestController {
	@GetMapping(value="rest", produces = "application/json; charset=utf-8")
	public Map<String, Object> get() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "get : 데이터 요청");
		return map;
	}
	@PostMapping(value="rest", produces = "application/json; charset=utf-8")
	public Map<String, Object> post() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "post : 데이터 전달");
		return map;
	}
	@PutMapping(value="rest", produces = "application/json; charset=utf-8")
	public Map<String, Object> put() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "put : 데이터 수정");
		return map;
	}
	@DeleteMapping(value="rest", produces = "application/json; charset=utf-8")
	public Map<String, Object> delete() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "delete : 데이터 삭제");
		return map;
	}
	@Autowired DBClass DB;
	@GetMapping(value="members", produces = "application/json; charset=utf-8")
	public ArrayList<InfoDTO> members() {
		
		return DB.DB;
	}
	@GetMapping(value="members/{uId}", produces = "application/json; charset=utf-8")//uId에 사용자가 지정한 값이 들어옴
	public InfoDTO getMember(@PathVariable String uId) {
		for(InfoDTO d : DB.DB) {
			if (d.getId().equals(uId)) {
				return d;
			}
		}
		
		return null;
	}
	@PostMapping(value="register", produces = "application/json; charset=utf-8")
	public String register(@RequestBody InfoDTO dto) {
		DB.DB.add(dto);
		
		return "{\"num\" : 1}";
	}
	@GetMapping(value="idChk/{uId}", produces = "application/json; charset=utf-8")
	public int idChk(@PathVariable String uId) {
		//select~
		
		for(InfoDTO d : DB.DB) {
			if (d.getId().equals(uId)) {
				return 1;
			}
		}
		
		return 0;
	}
	@DeleteMapping(value="delete", produces = "application/json; charset=utf-8")
	public int delete(@RequestParam String id) {
		//d wh id = id;
		
		for(int i = 0 ; i < DB.DB.size() ; i++) {
			if(DB.DB.get(i).getId().equals(id)) {
				DB.DB.remove(i);
			}
		}
		return 1;
	}
	@PutMapping(value="modify",  produces = "application/json; charset=utf-8")
	public int modify(@RequestBody InfoDTO dto) {
		//up set n=?, age = ? wh id=id
		for(int i = 0 ; i < DB.DB.size() ; i++) {
			if(DB.DB.get(i).getId().equals(dto.getId())) {
				DB.DB.set(i, dto);
			}
		}
		return 1;
	}
}
