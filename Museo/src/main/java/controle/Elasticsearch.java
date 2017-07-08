package controle;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.jr.ob.JSON;
import java.util.Collections;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.StringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import modelo.*;
import org.apache.http.util.EntityUtils;
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
    
    private RestClientBuilder builder;
    private JsonNodeFactory factory = JsonNodeFactory.instance;
    private ObjectMapper objectMapper;
    private RestClient restClient;
    
    private void criaIndexMapping()
    {
        
    }
    public Elasticsearch(String host,String port)
    {
        builder = RestClient.builder(new HttpHost(host,Integer.valueOf(port),"http"));
        objectMapper = new ObjectMapper();
        restClient = builder.build();
    }
       
    /*
        Verifica se uma obra já existe com o identificador informado
        @param id id da obra que vai ser buscada na base
        @returns true se obra ja existe
                 false se não existe
    */
    public boolean verificaObra(String identificador)
    {
        return false;
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
       try{
            String obraJson = objectMapper.writeValueAsString(o); //transforma objeto em String JSON
            
            Response indexResponse = restClient.performRequest(
            "PUT", //HTTP METHOD
            param, // <nome do indice> / <tipo do documento> / <indice do documento>
            Collections.<String, String>emptyMap(),
            getEntity(obraJson)); //HTTP REQUEST JSON PAYLOAD
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
    
    private HttpEntity getEntity(String json) throws Exception
    {
        HttpEntity a;
        try
        {
            a = new StringEntity(json,"application/json", "utf-8");
        }
        catch(Exception e)
        {
            throw e;
        }
        return a;
    }
    
    public Obra[] buscaObra(String query) throws Exception//busca em TUDO
    {
        Response queryResult;
        try
        {
            String query_all = JSON.std //easy de compor json assim
                        //.with(JSON.Feature.PRETTY_PRINT_OUTPUT)
                        .composeString()
                        .startObject()
                          .startObjectField("query")
                            .startObjectField("match")
                                    .put("_all",query).end()
                                .end()
                            .end()
                        .finish();
 
            queryResult = restClient.performRequest(
            "GET", //digo aqui que quero inserir
            "/obras/_search", // <nome do indice> / <tipo do documento> / <indice do documento>
            Collections.<String, String>emptyMap(),
            getEntity(query_all)); //HTTP REQUEST JSON PAYLOAD
  
       }
       catch(Exception e)
       {
           throw e;
       }
       return deserializaObras(queryResult);
    }
    private Obra[] deserializaObras(Response r) throws Exception
    {
        try
        {
            JsonNode root = objectMapper.readTree(EntityUtils.toString(r.getEntity()));

            int numeroHits = root.path("hits").path("total").asInt();
            if(numeroHits > 0)
            {
                JsonNode hits = root.path("hits").path("hits");
                Obra obras[] = new Obra[numeroHits];
                int i=0;
                for (JsonNode node : hits) 
                {
                    System.out.println(node.path("nome").asText());
                    String tipoObra = node.path("_type").asText();
                    JsonNode no = node.path("_source");
                    switch (tipoObra) {
                        case "Escultura":
                            obras[i] = objectMapper.readValue(no.toString(),Escultura.class);
                            break;
                        case "Pintura":
                            obras[i] = objectMapper.readValue(no.toString(),Pintura.class);
                            break;
                        case "Arquitetura":
                            obras[i] = objectMapper.readValue(no.toString(),Arquitetura.class);
                            break;
                        default:
                            break;
                    }
                    i++;
                }
                return obras;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Obra l[] = new Obra[1];
        l[0] = new Pintura();
        return l;
    }
}
