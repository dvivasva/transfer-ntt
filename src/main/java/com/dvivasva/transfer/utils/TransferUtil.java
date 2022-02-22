package com.dvivasva.transfer.utils;

import com.dvivasva.transfer.Model.Transfer;
import com.dvivasva.transfer.dto.TransferDto;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class TransferUtil {

    public static TransferDto entityToDto(Transfer transfer){
        var transferDto=new TransferDto();
        BeanUtils.copyProperties(transfer,transferDto);
        return transferDto;
    }
    public static Transfer dtoToEntity(TransferDto transferDto){
        var entity=new Transfer();
        BeanUtils.copyProperties(transferDto,entity);
        return entity;
    }

    public static <T> Mono<T> extractMono(Mono<T> var){
        return var;
    }
    public static String initChartAccountOrCredit(String s){
        String[]aux=s.split("-");
        return aux[0];
    }
    public static String idOrigen(Mono<String> stringMono){
        String id=null;
        assert false;
        stringMono.map(id::equals);
        return id;
    }
    public static boolean idDestination(String val){
        String result =initChartAccountOrCredit(val);
        return Objects.equals(result, "CRE");
    }
    public static boolean idOrigin(String val){
        String result =initChartAccountOrCredit(val);
        return Objects.equals(result, "ACC");
    }




}
