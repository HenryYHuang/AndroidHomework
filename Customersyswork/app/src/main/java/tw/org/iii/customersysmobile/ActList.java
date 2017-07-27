package tw.org.iii.customersysmobile;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by iii on 2017/7/19.
 */

public class ActList extends ListActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] customers=getIntent().getExtras().getStringArray(CDictionary.BK_CUSTOMERS_DATA_LIST);

        ListAdapter adap = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                customers);

        setListAdapter(adap);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Bundle bund = new Bundle();
        bund.putInt(CDictionary.BK_CUSTOMERS_SATA_LIST_RESULT,position);
        Intent intent =new Intent();
        intent.putExtras(bund);
        setResult(0,intent);
        finish();

    }
}
