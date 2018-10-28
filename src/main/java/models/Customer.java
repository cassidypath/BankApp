package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = -496555144885133763L;
	protected int id;
	protected String UserName;
    protected String Password;
    protected String FirstName;
    protected String LastName;
    protected String UserType;
    protected List<Account> accounts = new ArrayList<Account>();

    public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String userName, String password, String firstName, String lastName, String userType,
			List<Account> accounts) {
		super();
		this.id = id;
		UserName = userName;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
		UserType = userType;
		this.accounts = accounts;
	}
	
	public Customer(int id, String userName, String password, String firstName, String lastName) {
		super();
		this.id = id;
		UserName = userName;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addAccount(Account a) {
        accounts.add(a);//add account to the user for customer to reference and use
    }
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
    

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((UserName == null) ? 0 : UserName.hashCode());
		result = prime * result + ((UserType == null) ? 0 : UserType.hashCode());
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (UserName == null) {
			if (other.UserName != null)
				return false;
		} else if (!UserName.equals(other.UserName))
			return false;
		if (UserType == null) {
			if (other.UserType != null)
				return false;
		} else if (!UserType.equals(other.UserType))
			return false;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", UserName=" + UserName + ", Password=" + Password + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", UserType=" + UserType + ", accounts=" + accounts + "]";
	}

}