package phantom.lancer.beans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import phantom.lancer.model.User;

public class UserDataModel extends ListDataModel<User> implements SelectableDataModel<User> {
	
	
	public UserDataModel() {  
    }  
  
    public UserDataModel(List<User> data) {  
        super(data);  
    }  
	

	@Override
	public Object getRowKey(User user) {
		// TODO Auto-generated method stub
		return user.getId();
	}

	@Override
	public User getRowData(String rowKey) {
		//In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
        
        List<User> users = (List<User>) getWrappedData();  
          
        for(User user : users) {  
            if(user.getId()==(Integer.valueOf(rowKey)))  
                return user;  
        }  
          
        return null;
	}

}
