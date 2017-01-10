package com.example.morga.applistview;

/**
 * Created by morga on 02/12/2016.
 */

public class Titular
{
    private String titulo;
    private String subtitulo;
    private String imagen;

    public Titular (String tit, String sub, String im)
    {
        titulo=tit;
        subtitulo=sub;
        imagen=im;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public String getSubtitulo()
    {
        return subtitulo;
    }

    public String getImagen() { return imagen; }
}
