package algs.chapter2.sidebar2;

/**
 * Encoding using string tables (woefully inefficient but functional).
 * 
 * @author George Heineman
 * @version 1.0, 7/17/08
 * @since 1.0
 */
public class EncodingTwo implements IQuery {

	public String table = "\n" +
		"1 H Hydrogen 1.00794\n" + 
		"2 He Helium 4.002602\n" + 
		"3 Li Lithium 6.941\n" + 
		"4 Be Beryllium 9.012182\n" + 
		"5 B Boron 10.811\n" + 
		"6 C Carbon 12.0107\n" + 
		"7 N Nitrogen 14.0067\n" + 
		"8 O Oxygen 15.9994\n" + 
		"9 F Fluorine 18.9984032\n" + 
		"10 Ne Neon 20.1797\n" + 
		"11 Na Sodium 22.98976928\n" + 
		"12 Mg Magnesium 24.3050\n" + 
		"13 Al Aluminium 26.9815386\n" + 
		"14 Si Silicon 28.0855\n" + 
		"15 P Phosphorus 30.973762\n" + 
		"16 S Sulfur 32.065\n" + 
		"17 Cl Chlorine 35.453\n" + 
		"18 Ar Argon 39.948\n" + 
		"19 K Potassium 39.0983\n" + 
		"20 Ca Calcium 40.078\n" + 
		"21 Sc Scandium 44.955912\n" + 
		"22 Ti Titanium 47.867\n" + 
		"23 V Vanadium 50.9415\n" + 
		"24 Cr Chromium 51.9961\n" + 
		"25 Mn Manganese 54.938045\n" + 
		"26 Fe Iron 55.845\n" + 
		"27 Co Cobalt 58.933195\n" + 
		"28 Ni Nickel 58.6934\n" + 
		"29 Cu Copper 63.546\n" + 
		"30 Zn Zinc 65.409\n" + 
		"31 Ga Gallium 69.723\n" + 
		"32 Ge Germanium 72.64\n" + 
		"33 As Arsenic 74.92160\n" + 
		"34 Se Selenium 78.96\n" + 
		"35 Br Bromine 79.904\n" + 
		"36 Kr Krypton 83.798\n" + 
		"37 Rb Rubidium 85.4678\n" + 
		"38 Sr Strontium 87.62\n" + 
		"39 Y Yttrium 88.90585\n" + 
		"40 Zr Zirconium 91.224\n" + 
		"41 Nb Niobium 92.90638\n" + 
		"42 Mo Molybdenum 95.94\n" + 
		"43 Tc Technetium [98]\n" + 
		"44 Ru Ruthenium 101.07\n" + 
		"45 Rh Rhodium 102.90550\n" + 
		"46 Pd Palladium 106.42\n" + 
		"47 Ag Silver 107.8682\n" + 
		"48 Cd Cadmium 112.411\n" + 
		"49 In Indium 114.818\n" +
		"50 Sn Tin 118.710\n" + 
		"51 Sb Antimony 121.760\n" + 
		"52 Te Tellurium 127.60\n" + 
		"53 I Iodine 126.90447\n" + 
		"54 Xe Xenon 131.293\n" + 
		"55 Cs Caesium 132.9054519\n" + 
		"56 Ba Barium 137.327\n" + 
		"57 La Lanthanum 138.90547\n" + 
		"58 Ce Cerium 140.116\n" + 
		"59 Pr Praseodymium 140.90765\n" + 
		"60 Nd Neodymium 144.242\n" + 
		"61 Pm Promethium [145]\n" + 
		"62 Sm Samarium 150.36\n" + 
		"63 Eu Europium 151.964\n" + 
		"64 Gd Gadolinium 157.25\n" + 
		"65 Tb Terbium 158.92535\n" + 
		"66 Dy Dysprosium 162.500\n" + 
		"67 Ho Holmium 164.93032\n" + 
		"68 Er Erbium 167.259\n" + 
		"69 Tm Thulium 168.93421\n" + 
		"70 Yb Ytterbium 173.04\n" + 
		"71 Lu Lutetium 174.967\n" + 
		"72 Hf Hafnium 178.49\n" + 
		"73 Ta Tantalum 180.94788\n" + 
		"74 W Tungsten 183.84\n" + 
		"75 Re Rhenium 186.207\n" + 
		"76 Os Osmium 190.23\n" + 
		"77 Ir Iridium 192.217\n" + 
		"78 Pt Platinum 195.084\n" + 
		"79 Au Gold 196.966569\n" + 
		"80 Hg Mercury 200.59\n" + 
		"81 Tl Thallium 204.3833\n" + 
		"82 Pb Lead 207.2\n" + 
		"83 Bi Bismuth 208.98040\n" + 
		"84 Po Polonium [209]\n" + 
		"85 At Astatine [210]\n" + 
		"86 Rn Radon [222]\n" + 
		"87 Fr Francium [223]\n" + 
		"88 Ra Radium [226]\n" + 
		"89 Ac Actinium [227]\n" + 
		"90 Th Thorium 232.03806\n" + 
		"91 Pa Protactinium 231.03588\n" + 
		"92 U Uranium 238.02891\n" + 
		"93 Np Neptunium [237]\n" + 
		"94 Pu Plutonium [244]\n" + 
		"95 Am Americium [243]\n" + 
		"96 Cm Curium [247]\n" + 
		"97 Bk Berkelium [247]\n" +
		"98 Cf Californium [251]\n" + 
		"99 Es Einsteinium [252]\n" +  
		"100 Fm Fermium [257]\n" + 
		"101 Md Mendelevium [258]\n" + 
		"102 No Nobelium [259]\n" + 
		"103 Lr Lawrencium [262]\n" + 
		"104 Rf Rutherfordium [261]\n" + 
		"105 Db Dubnium [262]\n" + 
		"106 Sg Seaborgium [266]\n" + 
		"107 Bh Bohrium [264]\n" + 
		"108 Hs Hassium [277]\n" + 
		"109 Mt Meitnerium [268]\n" + 
		"110 Ds Darmstadtium [281]\n" + 
		"111 Rg Roentgenium [272]\n" + 
		"112 Uub Ununbium [285]\n" + 
		"113 Uut Ununtrium [284]\n" + 
		"114 Uuq Ununquadium [289]\n" + 
		"115 Uup Ununpentium [288]\n" + 
		"116 Uuh Ununhexium [291]\n" + 
		"118 Uuo Ununoctium [294]\n";

	// What is the atomic weight of element number N?
	public float weight (int n ) {
		int idx = table.indexOf("\n" + n + " ");
		if (idx == -1) { return -1.0f; }
		int idx1 = table.indexOf(' ', idx+1); // prefix
		int idx2 = table.indexOf(' ', idx1+1); // name
		int idx3 = table.indexOf(' ', idx2+1); // weight
		if (table.charAt(idx3+1) == '[') {
			int num = 0;
			idx3++;
			while (table.charAt(++idx3) != ']') {
				num = 10*num + (table.charAt(idx3)-'0');
			}
			return num;
		} else {
			float num = 0;
			boolean decimal = false;
			char c;
			float fraction = 0;
			int base = 1;
			while ((c = table.charAt(++idx3)) != '\n') {
				if (c == '.') { decimal = true; continue; }
				if (decimal) {
					fraction = 10*fraction + (c-'0');
					base *= 10;
				} else {
					num = 10*num + (c-'0');
				}
			}
			
			return num + (fraction/base);
		}
	}
	
	// What is the atomic number of element named X?
	public int number (String s) {
		int idx = table.indexOf(" " + s + " ");
		if (idx == -1) { return -1; }
		
		int idx2 = table.lastIndexOf('\n', idx+1);
		
		int num = 0;
		while (table.charAt(++idx2) != ' ') {
			num = 10*num + (table.charAt(idx2)-'0');
		}
		return num;
	}
	
	// What is the name of element number N?
	public String name (int n) {
		int idx = table.indexOf("\n" + n + " ");
		if (idx == -1) { return null; }
		
		int idx1 = table.indexOf(' ', idx+1);  // prefix
		int idx2 = table.indexOf(' ', idx1+1); // name
		int idx3 = table.indexOf(' ', idx2+1); // weight
		return table.substring(idx2+1,idx3);
	}
	
	public String toString () { return " Encoding Two "; }

}
