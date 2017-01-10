package com.example.morga.applistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] datos;

    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String[] datos = new String[]{"Elemento1", "Elemento2", "Elemento3", "Elemento4", "Elemento5"};
         Titular[] datos = new Titular[]{
                        new Titular("Título 1", "Subtítulo largo 1", "ic_launcher"),
                        new Titular("Título 2", "Subtítulo largo 2", "ic_launcher"),
                        new Titular("Título 3", "Subtítulo largo 3", "ic_launcher"),
                        new Titular("Título 4", "Subtítulo largo 4","ic_launcher"),
                        new Titular("Título 5", "Subtítulo largo 5","ic_launcher"),
                        new Titular("Título 6", "Subtítulo largo 6","ic_launcher"),
                        new Titular("Título 7", "Subtítulo largo 7","ic_launcher"),
                        new Titular("Título 8", "Subtítulo largo 8","ic_launcher"),
                        new Titular("Título 9", "Subtítulo largo 9","ic_launcher"),
                        new Titular("Título 10", "Subtítulo largo 10","ic_launcher"),
                        new Titular("Título 11", "Subtítulo largo 11","ic_launcher"),
                        new Titular("Título 12", "Subtítulo largo 12","ic_launcher"),
                        new Titular("Título 13", "Subtítulo largo 13","ic_launcher"),
                        new Titular("Título 14", "Subtítulo largo 14","ic_launcher"),
                        new Titular("Título 15", "Subtítulo largo 15","ic_launcher"),};

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this, datos);

        lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        lstOpciones.setAdapter(adaptador);

        //ArrayAdapter<String> adaptator = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        //ListView lstOpciones = (ListView) findViewById(R.id.listViewDatos);
        //lstOpciones.setAdapter(adaptator);

        View header = getLayoutInflater().inflate(R.layout.list_header, null);
        lstOpciones.addHeaderView(header);

        //OnItemClick


        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id)
            {
                //Alternativa 1:
                String opcionSeleccionada = ((Titular)a.getItemAtPosition(position)).getTitulo();

                //Alternativa 2:
                //String opcionSeleccionada =((TextView)v.findViewById(R.id.LblTitulo)).getText().toString();

                //lblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);

                Toast.makeText(MainActivity.this, opcionSeleccionada,Toast.LENGTH_SHORT).show();
            }
        });


    }

    public class AdaptadorTitulares extends ArrayAdapter<Titular>
    {

        // Creamos una array de tipo Titular
        Titular[] datos;

        public AdaptadorTitulares(Context context, Titular[] datos)
        {
            //Lo primero que encontramos es el constructor
            // para nuestro adaptador, al que sólo pasaremos el contexto (que normalmente
            // será la actividad desde la que se crea el adaptador) y el array de datos a
            // mostrar, que en nuestro caso es un array de objetos de tipo Titular. En este
            // constructor tan sólo llamaremos al constructor padre tal como ya vimos al
            // principio de este artículo, pasándole nuestros dos parámetros (contexto y
            // datos) y el ID del layout que queremos utilizar (en nuestro caso el nuevo
            // que hemos creado, listitem_titular).
            super(context, R.layout.listitem_titular, datos);
            this.datos=datos;
        }

        //Redefinimos el método encargado de generar y rellenar con nuestros datos todos
        // los controles necesarios de la interfaz gráfica de cada elemento de la lista.
        // Este método es getView().
        // El método getView() se llamará cada vez que haya que
        // mostrar un elemento de la lista.
        public View getView(int position, View convertView, ViewGroup parent)
        {
            // Lo primero que debe hacer es “inflar” el layout XML que hemos creado.
            // Esto consiste en consultar el XML de nuestro layout y crear e inicializar
            // la estructura de objetos java equivalente. Para ello, crearemos un nuevo
            // objeto LayoutInflater y generaremos la estructura de objetos mediante su
            // método inflate(id_layout).
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_titular, null);


            // Tras esto, tan sólo tendremos que obtener la referencia a cada una
            // de nuestras etiquetas como siempre lo hemos hecho y asignar su texto
            // correspondiente según los datos de nuestro array y la posición del
            // elemento actual (parámetro position del método getView()).
            TextView lblTitulo = (TextView)item.findViewById(R.id.textViewTitulo);
            lblTitulo.setText(datos[position].getTitulo());

            TextView lblSubtitulo = (TextView)item.findViewById(R.id.textViewSubtitulo);
            lblSubtitulo.setText(datos[position].getSubtitulo());

            //Imagen
            ImageView imagen = (ImageView)item.findViewById(R.id.imageView);
            imagen.setImageResource(R.drawable.ic_launcher);



            return(item);
        }






    }
}
