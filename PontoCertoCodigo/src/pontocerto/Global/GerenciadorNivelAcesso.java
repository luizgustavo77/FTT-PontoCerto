/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Global;

/**
 *
 * @author thiag
 */
public class GerenciadorNivelAcesso
{
    private static GerenciadorNivelAcesso instancia;
    private static String nivelAcesso;

    private GerenciadorNivelAcesso()
    {

    }

    public static synchronized GerenciadorNivelAcesso obterInstancia()
    {
        if (instancia == null)
        {
            instancia = new GerenciadorNivelAcesso();
        }
        
        return instancia;
    }
    
    public String getNivelAcesso()
    {
        return nivelAcesso;
    }
    
    public void setNivelAcesso(String value)
    {
        nivelAcesso = value;
    }
}
