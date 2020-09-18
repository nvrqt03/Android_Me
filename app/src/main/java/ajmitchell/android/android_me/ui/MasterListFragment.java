package ajmitchell.android.android_me.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ajmitchell.android.android_me.R;
import ajmitchell.android.android_me.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {

    // mandatory empty constructor
    public MasterListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // inflate the fragment layout
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container,false);

        // get reference to the GridView
        GridView gridView = rootView.findViewById(R.id.images_grid_view);

        // create MasterList Adapter
        // this adapter takes in the context and an arrayList of all the image resources to display
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(mAdapter);

        // return the rootView
        return rootView;

    }
}
