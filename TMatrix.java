class TMatrix extends Matrix{
	private Matrix m1,m2;
	public TMatrix(Matrix _m1,Matrix _m2){
		super(_m1.r(),_m2.c());
		m1=_m1;
		m2=_m2;
	}
	public boolean tmatrix(){ return true; }
	public int complexity(){
		int tmp=0;
		if(m1.tmatrix()) tmp+=m1.complexity();
		if(m2.tmatrix()) tmp+=m2.complexity();
		return dim()*m1.c()+tmp;
	}
	public String toString(){
		return "("+m1.toString()+","+m2.toString()+")";
	}
}