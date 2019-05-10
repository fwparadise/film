package com.example.demo.controller;

import com.example.demo.entity.film;
import com.example.demo.entity.matchedFilm;
import com.example.demo.entity.resultVO;
import com.example.demo.service.filmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class filmController {
    private final filmService filmService;

    @Autowired
    public filmController(filmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(value = "/getPage")
    public resultVO getFilm(@RequestParam("current")int current,@RequestParam("size")int size){
        resultVO result=new resultVO();
        try{
            result.setData(filmService.getPage(current,size));
            result.setSuccess(true);
        }
        catch (Exception e){
            result.setSuccess(false);
            result.setData(null);
            result.setMessage(e.toString());
        }
        return result;
    }

    @GetMapping(value = "/getAll")
    public resultVO getAll(){
        resultVO result=new resultVO();
        try{
            result.setData(filmService.findAll());
            result.setSuccess(true);
        }
        catch (Exception e){
            result.setSuccess(false);
            result.setData(null);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "/getOne")
    public resultVO getOne(@RequestParam("id") String id){
        resultVO result=new resultVO();
        try{
            result.setData(filmService.findById(id));
            result.setSuccess(true);
        }
        catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping(value = "match")
    public resultVO match(@RequestParam("name") String name){
        resultVO result=new resultVO();
        try{
            result.setSuccess(true);
            List<film> filmList=filmService.match(name);
            List<matchedFilm>matchedFilmList=new ArrayList<>();
            for (film item:filmList) {
                matchedFilm match=new matchedFilm();
                match.setId(item.get_id());
                match.setValue(item.getTitle());
                matchedFilmList.add(match);
            }
            result.setData(matchedFilmList);
        }
        catch (Exception e){
            result.setSuccess(false);
            result.setData(null);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
