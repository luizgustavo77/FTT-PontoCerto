/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Application.DefaultCode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author thiag
 */
public class BuscaAutomaticaCep
{

    public static String[] buscarCep(String cep)
    {
        String json;

        try
        {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();

            // JOptionPane.showMessageDialog(null, json);
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");
            String array[] = new String[30];
            return array = json.split("\n");

            // JOptionPane.showMessageDialog(null, array);
//            logradouro = array[7];            
//            bairro = array[15];
//            cidade = array[19]; 
//            uf = array[23];
//            
//            jTxtLogradouro.setText(logradouro);
//            jTxtBairro.setText(bairro);
//            jTxtCidade.setText(cidade);
//            jTxtEstado.setText(uf);
            //JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
