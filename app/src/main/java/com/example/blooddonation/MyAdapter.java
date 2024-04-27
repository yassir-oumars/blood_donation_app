package com.example.blooddonation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ComponentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;

    ArrayList<User> List;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        List = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = List.get(position);
        holder.adresse.setText(user.getAdresse());
        holder.group_sanguin.setText(user.getGroup_sanguin());
        holder.nom_prénom.setText(user.getNom_prénom());
        holder.numero_phone.setText(user.getNumero_phone());

        Glide.with(holder.img.getContext())
                .load(user.getSurl())
                .placeholder(com.google.firebase.appcheck.interop.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView adresse, group_sanguin, nom_prénom, numero_phone;
        Button btnEnvoyer ;

        CircleImageView img ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            adresse = (TextView)itemView.findViewById(R.id.adresse);
            group_sanguin = (TextView)itemView.findViewById(R.id.typeBlood);
            nom_prénom = (TextView)itemView.findViewById(R.id.name);
            numero_phone = (TextView)itemView.findViewById(R.id.phoneNumber);

            btnEnvoyer = (Button)itemView.findViewById(R.id.btnEnvoyer);
        }
    }


}
