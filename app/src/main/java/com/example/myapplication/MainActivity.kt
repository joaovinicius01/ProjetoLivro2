import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.ListaLivro
import com.example.myapplication.R
import com.example.myapplication.FragmentA // Importar o FragmentA

class MainActivity : AppCompatActivity(), ListaLivro.OnLivroSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Verifica se a Activity está sendo criada pela primeira vez
        if (savedInstanceState == null) {
            // Substituir o fragmento inicial por ListaLivro
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListaLivro())
                .commit()
        }

        // Encontre o botão pela ID
        val btSegundaTela = findViewById<Button>(R.id.bt_segunda_tela)

        // Configura o listener de clique
        btSegundaTela.setOnClickListener {
            IrParaSegundaTela()
        }
    }

    private fun IrParaSegundaTela() {
        val segundaTela = Intent(this, SegundaTela::class.java)
        startActivity(segundaTela)
    }

    override fun onLivroSelected(livro: ListaLivro.Livro) {
        // Aqui você pode atualizar o fragment_a com os dados do livro selecionado
        val fragmentA = supportFragmentManager.findFragmentById(R.id.fragment_a) as FragmentA
        fragmentA.atualizarComLivro(livro)
    }
}
