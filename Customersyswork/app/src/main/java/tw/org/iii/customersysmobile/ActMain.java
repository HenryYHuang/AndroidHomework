package tw.org.iii.customersysmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActMain extends AppCompatActivity {
    CCustomerFactory factory = new CCustomerFactory();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data==null||data.getExtras()==null)
            return;
        if(requestCode == CDictionary.AID_ACTLIST) {
            int position = data.getExtras().getInt(CDictionary.BK_CUSTOMERS_SATA_LIST_RESULT);
            factory.MoveTo(position);
            DisplayCustomerInfo();

        }

    }

    private View.OnClickListener btnFirst_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MoveToFirst();
            DisplayCustomerInfo();
        }
    };

    private void DisplayCustomerInfo() {
        txtAccount.setText(factory.getCurrent().getAccount());
        txtName.setText(factory.getCurrent().getName());
        txtPhone.setText(factory.getCurrent().getPhone());
        txtEmail.setText(factory.getCurrent().getEmail());
        txtAddress.setText(factory.getCurrent().getAddress());
    }

    private View.OnClickListener btnPrevious_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MoveToPrevious();
            DisplayCustomerInfo();
        }
    };
    private View.OnClickListener btnNext_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MoveNext();
            DisplayCustomerInfo();

        }
    };
    private View.OnClickListener btnLast_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MoveToLast();
            DisplayCustomerInfo();

        }
    };
    private View.OnClickListener btnList_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String[] custimers=new String[factory.GetAll().length];
            int count=0;
            for(CCustomer c : factory.GetAll()) {
                custimers[count]=c.getName()+ "\r\n" + c.getPhone() + "/" +c.getEmail();
                count++;
            }

            Bundle bund = new Bundle();
            bund.putStringArray(CDictionary.BK_CUSTOMERS_DATA_LIST,custimers);
            Intent intent = new Intent(ActMain.this,ActList.class);
            intent.putExtras(bund);
            startActivityForResult(intent,CDictionary.AID_ACTLIST);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InitalComponent();
    }

    private void InitalComponent() {
        txtAccount = (EditText) findViewById(R.id.txtid);
        txtName = (EditText) findViewById(R.id.txtname);
        txtPhone = (EditText) findViewById(R.id.txtphone);
        txtEmail = (EditText) findViewById(R.id.txtemail);
        txtAddress = (EditText) findViewById(R.id.txtAddr);
        btnFirst = (Button) findViewById(R.id.btnTop);
        btnFirst.setOnClickListener(btnFirst_click);
        btnPrevious = (Button) findViewById(R.id.btnPre);
        btnPrevious.setOnClickListener(btnPrevious_click);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(btnNext_click);
        btnLast = (Button) findViewById(R.id.btnLast);
        btnLast.setOnClickListener(btnLast_click);
        btnList = (Button) findViewById(R.id.btnAll);
        btnList.setOnClickListener(btnList_click);
    }
    EditText txtAccount;
    EditText txtName;
    EditText txtPhone;
    EditText txtEmail;
    EditText txtAddress;
    Button btnFirst;
    Button btnPrevious;
    Button btnNext;
    Button btnLast;
    Button btnList;
}
