import java.util.*;

class MatrixChain {
	public static void main(String[] args) {
		int len = args.length;
		if (len < 2){
			System.out.println("An input of 2 arguments or more is required.");
			return;
		}
		int[] list = new int[len];
		ArrayList<Matrix> matrixlist = new ArrayList<Matrix>();
		for(int i=0;i<len;i++) list[i]=Integer.parseInt(args[i]);
		for(int i=0;i<len-1;i++) {
			matrixlist.add(new Matrix(list[i],list[i+1]));
			matrixlist.get(i).id=(i+1);
			System.out.println("A" + (i+1) + ": " + matrixlist.get(i).r() + "x" + matrixlist.get(i).c());
		}
		ArrayList<Matrix> done=perm(matrixlist,new ArrayList());
		Collections.sort(done);
		for(int i=0;i<done.size();i++) System.out.println(done.get(i).display());		
	}
	
	public static ArrayList<Matrix> perm(ArrayList<Matrix> list, ArrayList<Matrix> ret){
		if(list.size()==1){
			ret.add(list.get(0));
			return ret;
		}
		if(list.size()==2){
			ret.add(new TMatrix(list.get(0),list.get(1)));
			return ret;
		}
		for(int i=0;i<list.size()-1;i++){
			ArrayList<Matrix> s1=(ArrayList<Matrix>)list.clone();
			ArrayList<Matrix> s2=(ArrayList<Matrix>)list.clone();
			
			for (int j=list.size()-1; j>=i+1; j--) s1.remove(j);
			for (int j=i; j>=0; j--) s2.remove(j);
			
			s1=perm(s1,new ArrayList());
			s2=perm(s2,new ArrayList());
			
			for(int j=0;j<s1.size();j++)
				for(int k=0;k<s2.size();k++)
					ret.add(new TMatrix(s1.get(j),s2.get(k)));
		}		
		return ret;
	}
}

