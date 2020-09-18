package ajmitchell.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ajmitchell.android.android_me.R;
import ajmitchell.android.android_me.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {
    // listener that triggers callback in host activity
    OnImageClickListener mCallback;

    // interface to be implemented by MainActivity - specifying the method it triggers. takes position of the image the user clicks in our gridView
    public interface OnImageClickListener {
        void onImageSelected(int position);
    }

    //make sure the host activity implements the callback by checking onAttach


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                + " must implement OnImageClickListenr");
        }
    }

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
        final MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(mAdapter);

        // attach listener to gridView
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Trigger the callback method and pass in the position that was clicked
                mCallback.onImageSelected(position);
            }
        });

        // return the rootView
        return rootView;

    }
}
