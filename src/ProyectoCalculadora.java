import java.util.Scanner;

public class ProyectoCalculadora {


	public static Scanner Lect = new Scanner(System.in);
	public static float Num [] = new float [5];
	public static String Sig[]= new String [7];
	public static String Ope[]= {"/","*","-","+"};
	public static int j=5, resp=0, cambio=0;
	public static int x=1;
	public float resultado;

	public static void main(String[] args) {
	ProyectoCalculadora igual = new ProyectoCalculadora();
	

		System.out.println("¡Bienvendo!\nPara poder utilizar esta calculadora considera lo siguiente.");
		System.out.println("Deberas ingresar el numero [enter] y despues el signo de la operacion que se realiza [Enter].\nSolo soporta hasta 4 operaciones basicas.\n Si deseas obtener el resultado coloca '='");
		System.out.println("Operacion:");
		Num[0]= Lect.nextFloat();

		do{
			Sig[0] = Lect.next();
		}while(Sig[0].equals("="));
		
		//Segundo numero
		Num[1]= Lect.nextFloat();

		//Validacion de = o sigue la operacion
		Sig[1] = Lect.next();
		
		 
		//Recorrido de Matriz para el llenado de informacion
		for(x=1;x<j;x++){

			if(Sig[x].equals("=")){
				j=x;
				if(j>3) {j+=1;}
				resp=j;
				igual.resultadoF();
				break;
			}else if(x==3){
				Sig[x+1]="=";
				Num[x+1]= Lect.nextFloat();
			}else{
				Num[x+1]= Lect.nextFloat();
				Sig[x+1] = Lect.next();
			}

		}
		
		System.out.print("El resultado de toda la operacion es = "+ Num[0]);
	}


	public void resultadoF(){


		ProyectoCalculadora Operaciones= new ProyectoCalculadora();
		
		for(int r2=0;r2<4;r2++) {
			for	(int r1=0;r1<j;r1++){
				for(int r=0;r<j;r++){
					
					if(Sig[r].equals(Ope[r2])) { //Recorridos
						switch(Ope[r2]){
							case "/": 
								resultado = Operaciones.Division(Num[r], Num[r+1]);
								Num[r]=resultado;
								Num[r+1]=0;
								cambio=r;
								Operaciones.ordenarm();
								j-=1;
								r1=0;
								cambio=0;
								break;
							case "*": 
								resultado = Operaciones.Multiplicacion(Num[r], Num[r+1]);
								Num[r]=resultado;
								Num[r+1]=0;
								cambio=r;
								Operaciones.ordenarm();
								j-=1;
								r1=0;
								cambio=0;
								break;
							case "-": 
								resultado = Operaciones.Resta(Num[r], Num[r+1]);
								Num[r]=resultado;
								Num[r+1]=0;
								cambio=r;
								Operaciones.ordenarm();
								j-=1;
								r1=0;
								cambio=0;
								break;
							case "+": 
								resultado = Operaciones.Suma(Num[r], Num[r+1]);
								Num[r]=resultado;
								Num[r+1]=0;
								cambio=r;
								Operaciones.ordenarm();
								j-=1;
								r1=0;
								cambio=0;
								break;
						}
						
					}
				}
			}
			
		}	
	}

	
	public void ordenarm() {
		int b =1, c=1, d=0;
		for(int a = 0; a<Num.length; a++) {
			if(Num[a]==0) {
				if(a+1==Num.length) {
					break;
				}else {
						if(Num[a+1]>0) {
							float tmp1=Num[a+1];
							Num[a]=tmp1;
							Num[a+1]=0;
							
						String tmp2=Sig[a];
						if(tmp2=="") {
							tmp2=Sig[a+1];
							b=0;
							c=2;
							d=1;
						}
						Sig[a-b]=tmp2;
						String temp3= Sig[a+c];
						Sig[a+d]= temp3;
						Sig[a+1]="";
						cambio=0;
					}
					
				}
			}	
		}
		if(cambio>0){
			String tmp2=Sig[cambio+1];
			if(tmp2=="") {
				tmp2=Sig[cambio+2];
			}
			Sig[cambio]=tmp2;
			String temp3= Sig[cambio+2];
			Sig[cambio+1]= temp3;
			Sig[cambio+1]="";
		}
	}

	public float Suma(float V1, float V2) {
		return V1+V2;
	}
	public float Resta(float V1, float V2) {
		return V1-V2;
	}
	public float Multiplicacion(float num2, float num3) {
		return num2 * num3;
	}

	public float Division(float num2, float num3) {
		return num2 / num3;
	}
}
