package com.example.parkingapp.unimagadalena.parkingapp;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
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

    public Lista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        listView = (ListView)v.findViewById(R.id.listViewLista);

        ArrayList<Product> products = new ArrayList<>();


        products.add(new Product("El Tesoro", "Cra. 21c #29A-38", R.drawable.park1));
        products.add(new Product("La Guaca", "Cra. 22 #33a-2 a 33a-34", R.drawable.guaca));
        products.add(new Product("Park Center", "Cra. 29 #29j-10 a 29j-52", R.drawable.park));
        products.add(new Product("Cubriseal", "Cra. 2 #16-2 a 16-76", R.drawable.cubriseal));
        products.add(new Product("Paso Nivel", "Cra. 19b #26a-2 a 26a-74", R.drawable.pasonivel));
        products.add(new Product("Pavimark", "Cl. 17 #7-161 a 7-1", R.drawable.pavimark));
        products.add(new Product("El Cartel", "Cl. 23 #6-2 a 6-122", R.drawable.cartel));
        products.add(new Product("Socoda", "Cl. 29L1 #54", R.drawable.pasonivel));

        listView.setAdapter(new ListProductAdapter(getContext(), products));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {

                        Intent myIntent = new Intent(getContext(), Informacion.class);
                        startActivity(myIntent);

               
            }
        });
        return v;
        }

    public class Product {
        String name;
        String direccion;
        int image;

        public Product(String name, String price, int image) {
            this.name = name;
            this.direccion = direccion;
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



