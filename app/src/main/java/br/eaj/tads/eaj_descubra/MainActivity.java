package br.eaj.tads.eaj_descubra;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Context context;
    TabLayout tabLayout;
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

    final String[] permissoes = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imagem = (ImageView) findViewById(R.id.image_header);
        imagem.setImageResource(R.drawable.eaj);

        ViewPager vp = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pa = new FixedTabsPageAdapter(getSupportFragmentManager());

        vp.setAdapter(pa);

        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(vp);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    imagem = (ImageView) findViewById(R.id.image_header);
                    imagem1 = (ImageView) findViewById(R.id.img1);
                    imagem2 = (ImageView) findViewById(R.id.img2);
                    imagem3 = (ImageView) findViewById(R.id.img3);
                    imagem4 = (ImageView) findViewById(R.id.img4);
                    imagem5 = (ImageView) findViewById(R.id.img5);
                    desc = (TextView) findViewById(R.id.descricao1);
                    resp = (TextView) findViewById(R.id.respo);
                    tel = (TextView) findViewById(R.id.telefone);
                    email = (TextView) findViewById(R.id.email);
                    horario = (TextView) findViewById(R.id.horario);
                    imagem = (ImageView) findViewById(R.id.image_header);
                    nome1 = (TextView) findViewById(R.id.nome1);
                    desc2 = (TextView) findViewById(R.id.descricao2);
                    resp2 = (TextView) findViewById(R.id.respo2);
                    tel2 = (TextView) findViewById(R.id.telefone2);
                    email2 = (TextView) findViewById(R.id.email2);
                    horario2 = (TextView) findViewById(R.id.horario2);
                    mensagem = (TextView) findViewById(R.id.mensagem);

                    imagem.setImageResource(R.drawable.eaj);
                    imagem1.setVisibility(View.GONE);
                    imagem2.setVisibility(View.GONE);
                    imagem3.setVisibility(View.GONE);
                    imagem4.setVisibility(View.GONE);
                    imagem5.setVisibility(View.GONE);
                    nome1.setVisibility(View.GONE);
                    desc.setVisibility(View.GONE);
                    desc2.setVisibility(View.GONE);
                    resp.setVisibility(View.GONE);
                    resp2.setVisibility(View.GONE);
                    tel.setVisibility(View.GONE);
                    tel2.setVisibility(View.GONE);
                    email.setVisibility(View.GONE);
                    email2.setVisibility(View.GONE);
                    horario.setVisibility(View.GONE);
                    horario2.setVisibility(View.GONE);
                    mensagem.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for (int result : grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                alertAndFinish();
                return;
            }
        }
    }

    private void alertAndFinish() {
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Permissões").setMessage("Para utilizar este aplicativo, você precisa aceitar as permissões.");

            builder.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setPositiveButton("Permitir", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        PermissionUtils.validate(this, 0, permissoes);
    }
}
