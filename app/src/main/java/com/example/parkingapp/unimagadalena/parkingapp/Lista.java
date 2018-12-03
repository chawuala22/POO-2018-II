package com.example.parkingapp.unimagadalena.parkingapp;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lista extends Fragment  {
    ListView listView;

    View v;
    ArrayList<Product> products = new ArrayList<>();


    public Lista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        listView = (ListView)v.findViewById(R.id.listViewLista);

        int m = R.drawable.park1;

        products.add(new Product(1,"El Tesoro", "Cra. 21c #29A-38", "Ernesto Campo","22.000",
                "8:00 am - 11:00 pm","70",m));

        products.add(new Product(2,"La Guaca", "Cra. 22 #33a-2 a 33a-34","Brian Calsadilla","11.000",
                "10:00 am - 11:00 pm","40",R.drawable.guaca));

        products.add(new Product(3,"Park Center", "Cra. 29 #29j-10 a 29j-52","Luis Carlos Galán","15.000",
                "24 horas","15",R.drawable.park));

        products.add(new Product(4,"Cubriseal", "Cra. 2 #16-2 a 16-76","Cristian Lopez","14.000",
                "24 Horas","30",R.drawable.cubriseal));

        products.add(new Product(5,"Paso Nivel", "Cra. 19b #26a-2 a 26a-74","Jorge Romero","14.000",
                "8:00 am - 10:00 pm","20",R.drawable.pasonivel));

        products.add(new Product(6,"Pavimark", "Cl. 17 #7-161 a 7-1","Oscar Leon","17.000",
                "6:00 am - 10:00 pm","25",R.drawable.pavimark));

        products.add(new Product(7,"El Cartel", "Cl. 23 #6-2 a 6-122","Gilma Lopez","20.000",
                "24 horas","25",R.drawable.cartel));

        products.add(new Product(8,"Socoda", "Cl. 29L1 #54","Omar Cantillo","15.000",
                "24 horas","40",R.drawable.pasonivel));

        listView.setAdapter(new ListProductAdapter(getContext(), products));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                String name;
                String diree;
                String propi;
                String costo;
                String hora;
                String cupo;


                for(Product list : products){
                    if(list.getId()-1 == position) {
                        name = list.getName();
                        diree=list.getDireccion();
                        propi=list.getPropietario();
                        costo=list.getCostar();
                        hora=list.getHora();
                        cupo=list.getCup();

                        Intent intent = new Intent(getContext(), Informacion.class);

                        intent.putExtra("name", name);
                        intent.putExtra("dire", diree);
                        intent.putExtra("propi", propi);
                        intent.putExtra("costo", costo);
                        intent.putExtra("horar", hora);
                        intent.putExtra("cup", cupo);


                        startActivity(intent);
                    }
                }
            }
        });
        return v;
    }

    public class Product {
        int id;
        String name;
        String direccion;
        String propietario;
        String costar;
        String Hora;
        String cup;

        int image;

        public Product(int id, String name, String direccion,String propietario, String costar, String Hora,String cup, int image) {
            this.id = id;
            this.name = name;
            this.direccion = direccion;
            this.costar=costar;
            this.image = image;
            this.Hora=Hora;
            this.cup=cup;
            this.propietario=propietario;
        }



        public String getCup() {
            return cup;
        }

        public void setCup(String cup) {
            this.cup = cup;
        }

        public String getHora() {
            return Hora;
        }

        public void setHora(String hora) {
            Hora = hora;
        }

        public String getCostar() {
            return costar;
        }

        public void setCostar(String costar) {
            this.costar = costar;
        }

        public String getPropietario() {
            return propietario;
        }

        public void setPropietario(String propietario) {
            this.propietario= propietario;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }

    static class ListProductAdapter extends BaseAdapter {
        private final Context context;
        private final ArrayList<Product> products;

        public ListProductAdapter(Context context, ArrayList<Product> products) {
            this.context = context;
            this.products = products;
        }

        @Override
        public int getCount() {
            return products.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);


            Product product = products.get(position);
            ListViewHolder holder;
            if (view == null) {
                view = inflater.inflate(R.layout.info_item, viewGroup, false);
                holder = new ListViewHolder();
                holder.txtName = (TextView) view.findViewById(R.id.category);
                holder.txtDireccion = (TextView) view.findViewById(R.id.texto);
                holder.imgProduct = (ImageView) view.findViewById(R.id.imageView4);

                view.setTag(holder);
            } else {
                Log.d("ListView", "RECYCLED");
                holder = (ListViewHolder) view.getTag();
            }

            holder.txtName.setText(product.name);
            holder.txtDireccion.setText(product.direccion);
            holder.imgProduct.setImageResource(product.image);
            return view;
        }

        static class ListViewHolder {
            TextView txtName;
            TextView txtDireccion;
            ImageView imgProduct;
        }
    }
}