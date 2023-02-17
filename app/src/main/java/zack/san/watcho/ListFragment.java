package zack.san.watcho;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.RealmResults;
import zack.san.watcho.Adapters.MyRecyclerViewAdapter;
import zack.san.watcho.repository.RealmRepository;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    RealmResults<Anime> animeArrayList;
    MyRecyclerViewAdapter adapter;
    private RealmRepository realmRepository;


    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = v.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        realmRepository = new RealmRepository();
        animeArrayList = realmRepository.getAll();
//        animeArrayList.add(new Anime("One Punch Man", 24, "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/d8eed44e3d48097ab5fd36b6815fc18e.jpe"));
//        animeArrayList.add(new Anime("Great Teacher Onizuka",  43,"https://upload.wikimedia.org/wikipedia/en/b/b9/GTO_volume_1.jpg"));
//        animeArrayList.add(new Anime("Naruto", 220,"https://upload.wikimedia.org/wikipedia/en/9/94/NarutoCoverTankobon1.jpg"));
//        animeArrayList.add(new Anime("Cowboy Bebop", 26,"https://m.media-amazon.com/images/M/MV5BM2FiZmEzOGItODI3Ni00MDk2LWJhZWQtNGM2ODhlMWMzODZhXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_FMjpg_UX1000_.jpg"));
//        animeArrayList.add(new Anime("Death Note", 37, "https://cdn.myanimelist.net/images/anime/9/21498l.jpg"));
//        animeArrayList.add(new Anime("Attack on Titan", 75, "https://cdn.myanimelist.net/images/anime/1824/110939l.jpg"));
//        animeArrayList.add(new Anime("Fullmetal Alchemist", 27, "https://image.myanimelist.net/ui/2WKqUufwTqFEmbnAXxxIeLHjalfqphl2Trm-pNsdMAGJW7bM3aUxCQkTceY86CX1sXBe_xB_2gaircB1lDTPG_6CqWbiUwKauKozKnKopT3Yg52OblsZSxwphQcvArup"));
//        animeArrayList.add(new Anime("One Piece", 1000, "https://comicvine.gamespot.com/a/uploads/scale_small/11161/111610434/8594314-9160985681-97840.jpg"));
//        animeArrayList.add(new Anime("Demon Slayer", 23, "https://demonslayer-anime.com/risshihen/assets/img/top/img_main_sp.jpg"));

        adapter = new MyRecyclerViewAdapter(getActivity(),animeArrayList);
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return v;


    }
}