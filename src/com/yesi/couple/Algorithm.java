package com.yesi.couple;

public class Algorithm 
{
	public int[] chosungArr ={2, 4, 2, 3, 6, 5, 4, 4, 8, 2, 4, 1, 3, 6, 4, 3, 4, 4, 3};
    			//            ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ ㅁ ㅂ ㅃ ㅅ ㅆ ㅇ ㅈ ㅉ ㅊ ㅋ ㅍ ㅌ ㅎ
    public int[] joongsungArr = {2, 3, 3, 4, 2, 3, 3, 4, 2, 4, 5, 3, 3, 2, 4, 5, 3, 3, 1, 2, 1};
    				//             ㅏ ㅐ ㅑ ㅒ ㅓ ㅔ ㅕ ㅖ ㅗ ㅘ ㅙ ㅚ ㅛ ㅜ ㅝ ㅞ ㅟ ㅠ ㅡ ㅢ ㅣ
    public int[] jongsungArr = {0, 2, 4, 4, 2, 5, 5, 3, 5, 7, 9, 9, 7, 9, 9, 8, 4, 4, 6, 2, 4, 1, 3, 4, 3, 4, 4, 3};
    			//             무 ㄱ ㄲ ㄳ ㄴ ㄵ ㄶ ㄷ ㄹ ㄺ ㄻ ㄼ ㄽ ㄾ ㄿ ㅀ ㅁ ㅂ ㅄ ㅅ ㅆ ㅇ ㅈ ㅊ ㅋ ㅌ ㅍ ㅎ
    
	public Algorithm() {
		// TODO Auto-generated constructor stub
	}
	
	public int strokeCount(char c)
	{
		
		int letter = 0;
		int chosung = 0;
		int joongsung = 0;
		int jongsung = 0;
		int result = 0;
		
		letter = (int)c-44032;
			
		chosung = letter/(21*28);
		joongsung = letter%(21*28)/28;
		jongsung = letter %28;

		result = chosungArr[chosung]+joongsungArr[joongsung]+jongsungArr[jongsung];
		
		return result;
	}
	
	public int percent(String myName,String yourName)
	{
		int myNameLength = myName.length();
		int yourNameLength = yourName.length();
		int totalLength = myNameLength+yourNameLength;
		int[] arr = new int[totalLength];
		
		for(int i = 0;i<myNameLength;i++)
		{
			if(i<yourNameLength)
			{
				arr[i*2] = strokeCount(myName.charAt(i));
			}
			else
			{
				arr[yourNameLength+i] = strokeCount(myName.charAt(i));
			}
		}
		
		for(int i = 0;i<yourNameLength;i++)
		{
			if(i<myNameLength)
			{
				arr[i*2+1] = strokeCount(yourName.charAt(i));
			}
			else
			{
				arr[myNameLength+i] = strokeCount(yourName.charAt(i));
			}
		}
		
		for(int l = totalLength;l>=3;l--)
		{
			for(int i = 1;i<l;i++)
			{
				arr[i-1] = arr[i]+arr[i-1];
				arr[i-1] = arr[i-1]%10;
			}
		}
		
		return arr[0]*10+arr[1];
	}
	
	public String message(String myName,String yourName)
	{
		int couple = 0;

		for(int i = 0;i <myName.length();i++)
		{
			couple += strokeCount(myName.charAt(i));
		}

		for(int i = 0;i <yourName.length();i++)
		{
			couple += strokeCount(yourName.charAt(i));
		}

		String result="";

		couple = couple%40;
		
		
		switch(couple)
		{
		case 0: result = "평생 갈사람"; break;
		case 1: result = "이별하기 쉬움"; break;
		case 2: result = "2년이상 오래감"; break;
		case 3: result = "지금 애인과 평생감"; break;
		case 4: result = "진실한 사랑"; break;
		case 5: result = "절교"; break;
		case 6: result = "안타깝게 기다림"; break;
		case 7: result = "서로 사랑"; break;
		case 8: result = "혼자 사랑"; break;
		case 9: result = "죽어서도 좋아해"; break;
		case 10: result = "좋아해"; break;
		case 11: result = "거짓 사랑"; break;
		case 12: result = "싫으면서 좋은것"; break;
		case 13: result = "마음과 정반대"; break;
		case 14: result = "인연"; break;
		case 15: result = "남자가 여자때문에 움"; break;
		case 16: result = "무질주 사랑"; break;
		case 17: result = "잠시 좋음"; break;
		case 18: result = "영원함"; break;
		case 19: result = "다시 사귐"; break;
		case 20: result = "사랑을 위해서라면"; break;
		case 21: result = "이별"; break;
		case 22: result = "미래의 키스"; break;
		case 23: result = "잊을 수 없는 사랑"; break;
		case 24: result = "양다리"; break;
		case 25: result = "이제 곧 데이트"; break;
		case 26: result = "서로 사랑"; break;
		case 27: result = "운명적 만남"; break;
		case 28: result = "운명적 실수"; break;
		case 29: result = "결혼가능"; break;
		case 30: result = "여자가 남자조심"; break;
		case 31: result = "여자가 아까움"; break;
		case 32: result = "남자가 여자조심"; break;
		case 33: result = "남자가 짝사랑"; break;
		case 34: result = "여자가 남자때문에 움"; break;
		case 35: result = "깨지기 쉬움"; break;
		case 36: result = "어울리지 않음"; break;
		case 37: result = "남자가 아까움"; break;
		case 38: result = "여자는 좋아하지만 남자가 좋아하지 않음"; break;
		case 39: result = "여자가 짝사랑"; break;
		default: break;
		}

		return result;
	}
}
