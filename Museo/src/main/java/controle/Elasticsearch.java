package controle;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Collections;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.StringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import modelo.Obra;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tech
 */
public class Elasticsearch {
    
    //private String host = "localhost";
    //private String port = "9200";
    private RestClientBuilder builder;
    private JsonNodeFactory factory = JsonNodeFactory.instance;
    private ObjectMapper objectMapper;
    public static boolean UPDATE = true;
    public static boolean NO_UPDATE = false;
    
    public Elasticsearch(String host,String port)
    {
        builder = RestClient.builder(new HttpHost(host,Integer.valueOf(port),port));
        objectMapper = new ObjectMapper();
    }
       
    /*
        Verifica se uma obra já existe com o identificador informado
        @param id id da obra que vai ser buscada na base
        @returns true se obra ja existe
                 false se não existe
    */
    public boolean verificaObra(String identificador)
    {
        return true;
    }
    public boolean insereObra(Obra o,boolean atualizaRegistro)
    {
        if(!atualizaRegistro)
        {
            if(verificaObra(o.getIdentificador()))
            {
                System.out.println("MENSAGEM DE ERRO, OBRA JA EXISTE!!");
                return false;
            }
        }
       
       
       String param = String.format("/obras/%s/%s",o.getClass().getSimpleName(),o.getIdentificador());
       HttpEntity entity;
       try{
            String pinturaJson = objectMapper.writeValueAsString(o); //transforma objeto em String JSON
            entity = new StringEntity(pinturaJson,"application/json", "utf-8"); //prepara requisiçao http com payload JSON
            RestClient restClient = builder.build();
            
            Response indexResponse = restClient.performRequest(
            "PUT", //HTTP METHOD
            param, // <nome do indice> / <tipo do documento> / <indice do documento>
            Collections.<String, String>emptyMap(),
            entity); //HTTP REQUEST JSON PAYLOAD
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       return true;
    }
    
    /*
        Procura por obras com string em qualquer um dos campos, caso um campo não tenha sido especificado.
        Filtra resultados em um intervalo de datas
        @param query texto a ser procurado
        @param campoData campo a ter a data verificada se esta compreendida no intervalo
        @param dataInicio incio do intervalo de datas para filtragem
        @param datafim fim do i ntervalo de datas para filtragem
        @param campoEspecifico - opcional, informa um campo a ser buscado especificamente, autor da obra, por exemplo.
    */
    public Obra[] buscaObra(String query,String campoData,String dataInicio, String dataFim,String campoEspecifico)
    {
        ObjectNode root = factory.objectNode();
        Obra o[] = new modelo.Pintura[1];
        
        return o;
    }
}
