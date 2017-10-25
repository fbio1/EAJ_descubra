package br.eaj.tads.eaj_descubra;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class FragmentRecycler extends Fragment {
    private List<Departamentos> departamentosList;
    ImageView imagem;
    ImageView imagem1;
    ImageView imagem2;
    ImageView imagem3;
    ImageView imagem4;
    ImageView imagem5;
    TextView nome1;
    TextView desc;
    TextView desc2;
    TextView resp;
    TextView resp2;
    TextView tel;
    TextView tel2;
    TextView email;
    TextView email2;
    TextView horario;
    TextView horario2;
    TextView mensagem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        departamentosList = new ArrayList<>();
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerview);

        carregaFrutas();

        final DetalhesAdapter detalhesAdapter = new DetalhesAdapter(getContext(), departamentosList);

        recyclerView.setAdapter(detalhesAdapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layout);

        recyclerView.addOnItemTouchListener(
                new br.eaj.tads.eaj_descubra.RecyclerView(
                        getContext(),
                        recyclerView,
                        new br.eaj.tads.eaj_descubra.RecyclerView.OnItemClickListener(){

                        @Override
                        public void OnItemClick(View view, int i) {
                            //padrões
                            desc = getActivity().findViewById(R.id.descricao1);
                            resp = getActivity().findViewById(R.id.respo);
                            tel = getActivity().findViewById(R.id.telefone);
                            email = getActivity().findViewById(R.id.email);
                            horario = getActivity().findViewById(R.id.horario);

                            //Principal
                            imagem = getActivity().findViewById(R.id.image_header);
                            imagem1 = getActivity().findViewById(R.id.img1);
                            imagem2 = getActivity().findViewById(R.id.img2);
                            imagem3 = getActivity().findViewById(R.id.img3);
                            imagem4 = getActivity().findViewById(R.id.img4);
                            imagem5 = getActivity().findViewById(R.id.img5);
                            nome1 = getActivity().findViewById(R.id.nome1);
                            desc2 = getActivity().findViewById(R.id.descricao2);
                            resp2 = getActivity().findViewById(R.id.respo2);
                            tel2 = getActivity().findViewById(R.id.telefone2);
                            email2 = getActivity().findViewById(R.id.email2);
                            horario2 = getActivity().findViewById(R.id.horario2);

                            mensagem = getActivity().findViewById(R.id.mensagem);
                            mensagem.setVisibility(View.GONE);

                            nome1.setVisibility(View.VISIBLE);
                            desc.setVisibility(View.VISIBLE);
                            desc2.setVisibility(View.VISIBLE);
                            resp.setVisibility(View.VISIBLE);
                            resp2.setVisibility(View.VISIBLE);
                            tel.setVisibility(View.VISIBLE);
                            tel2.setVisibility(View.VISIBLE);
                            email.setVisibility(View.VISIBLE);
                            email2.setVisibility(View.VISIBLE);
                            horario.setVisibility(View.VISIBLE);
                            horario2.setVisibility(View.VISIBLE);
                            imagem1.setVisibility(View.VISIBLE);
                            imagem2.setVisibility(View.VISIBLE);
                            imagem3.setVisibility(View.VISIBLE);
                            imagem4.setVisibility(View.VISIBLE);
                            imagem5.setVisibility(View.VISIBLE);

                            imagem.setImageResource(departamentosList.get(i).getImagem());
                            nome1.setText(departamentosList.get(i).getNome());
                            desc2.setText(departamentosList.get(i).getDescricao());
                            resp2.setText(departamentosList.get(i).getResponsavel());
                            tel2.setText(departamentosList.get(i).getTelefone());
                            email2.setText(departamentosList.get(i).getEmail());
                            horario2.setText(departamentosList.get(i).getHorario_funcionamento());

                            TabLayout tablayout = getActivity().findViewById(R.id.tab);
                            tablayout.getTabAt(1).select();
                        }

                        @Override
                        public void OnItemLongClick(View view, int i) {
                            Toast.makeText(getContext(), "Tente clique simples", Toast.LENGTH_SHORT).show();
                        }
                    }));

        return v;
    }


    public void carregaFrutas() {
        departamentosList.add((new Departamentos(R.drawable.info, "Prédio de Informatica", "lala", "lala", "lala", "teste2", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.apico, "Apícolas", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.aqui, "Aquicultura", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.biblioteca, "Biblioteca", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.aloj_mas, "Alojamento Masculino", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.aloja_fem, "Alojamento Feminino", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.avi, "Avicultura", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.capela, "Capela", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.cvt, "CVT", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.diracao, "Direção", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.drirecao_etec, "Direção ETEC", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.graduacao, "Graduação", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.gremio, "Grêmio", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.instituto, "Instituto do bosque", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.medio, "Ensino Médio", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.pecu_indus, "Agropecuaria e Agroindustria", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.quadra, "Quadra", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
        departamentosList.add((new Departamentos(R.drawable.ru, "Restaurante Universitario", "lala", "lala", "lala", "lala", "08:00hrs - 17:00hrs")));
    }
}
