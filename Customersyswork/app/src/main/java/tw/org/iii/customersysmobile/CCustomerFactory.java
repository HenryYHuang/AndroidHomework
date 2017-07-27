package tw.org.iii.customersysmobile;

import java.util.ArrayList;

/**
 * Created by iii on 2017/7/19.
 */

public class CCustomerFactory {
    ArrayList<CCustomer> list = new ArrayList<CCustomer>();
    int position = 0;

    public CCustomerFactory(){
        LoadData();
    }

    private void LoadData() {
        list.add(new CCustomer("A001","Jordan","0910123456","jordan@gmail.com","台北市"));
        list.add(new CCustomer("A002","Pippen","0920987654","pippen@outlook.com","台中市"));
        list.add(new CCustomer("A003","Allen","0930135246","allen@yahoo.com","高雄市"));
        list.add(new CCustomer("A004","Rodman","0940258468","rodman@gmail.com","南投市"));
        list.add(new CCustomer("A005","Curry","0940258468","curry@outlook.com","新北市"));
        list.add(new CCustomer("A006","James","0940258468","james@yahoo.com","基隆市"));
        list.add(new CCustomer("A007","Carter","0940258468","carter@gmail.com","新竹市"));
        list.add(new CCustomer("A008","Malong","0940258468","malong@outlook.com","台東市"));
        list.add(new CCustomer("A009","Jarbar","0940258468","jarbar@yahoo.com","花蓮市"));
        list.add(new CCustomer("A010","Johnson","0940258468","johnson@gmail.com","台南市"));
    }
    public  void MoveToFirst() {
        position=0;
    }
    public  void MoveToPrevious() {
        position--;
        if(position<0)
            position=0;
    }
    public  void  MoveNext() {
        position++;
        if(position>=list.size())
            MoveToLast();
    }
    public  void MoveToLast() {
        position=list.size()-1;
    }
    public  void MoveTo(int to) {
        position=to;
    }
    public  CCustomer getCurrent() {
        return  list.get(position);
    }
    public CCustomer[] GetAll() {
        return  list.toArray(new CCustomer[list.size()]);
    }

}
