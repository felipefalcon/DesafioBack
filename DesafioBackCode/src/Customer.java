public class Customer {
	private int id_customer;
	private String cpf_cnpj;
	private String nm_customer;
	private String is_active;
	private Long vl_total;

	public int getId_customer() {
		return id_customer;
	}

	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getNm_customer() {
		return nm_customer;
	}

	public void setNm_customer(String nm_customer) {
		this.nm_customer = nm_customer;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public Long getVl_total() {
		return vl_total;
	}

	public void setVl_total(Long vl_total) {
		this.vl_total = vl_total;
	}

	public Customer(int id_customer, String cpf_cnpj, String nm_customer, String is_active, Long vl_total) {
		this.id_customer = id_customer;
		this.cpf_cnpj = cpf_cnpj;
		this.nm_customer = nm_customer;
		this.is_active = is_active;
		this.vl_total = vl_total;
	}

	public String toString() {
		return "Customer [id_customer=" + id_customer + ", cpf_cnpj=" + cpf_cnpj + ", nm_customer=" + nm_customer
				+ ", is_active=" + is_active + ", vl_total=" + vl_total + "]";
	}
	
}
