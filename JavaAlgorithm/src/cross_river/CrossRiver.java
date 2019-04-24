package cross_river;

/* ----Noraneko----
 * 标题: 小明家过河问题
 * 描述: 小明一家过河, 过一次所需时间小明1s,姐姐3s,弟弟6s,奶奶8s,爷爷12s.一次最多2人,手电筒可提供30s. 询问过河方法
 */
public class CrossRiver {
	static int solutionCount = 0;
	//表示起点的人员情况, 第一个是小明,最后一个是爷爷,按照过河时间升序对应.0表示不在,用过河所需时间表示在.
	static int[] start = {1,3,6,8,12};	
	//表示终点人员情况,数字对应同上.
	static int[] end = {0,0,0,0,0};	
	static int step = 0; //两人过河或者一人返回算作1步,第7步结束时所有人都完成过河.
	static int time = 0; //总时间
	static String solution = "";  //走的方法.
	
	public static void main(String[] args) {
		go(solution);
	}
	
	//过河一步
	public static void go (String solution){
		//尝试让两个人去对岸.先选择第一个
		for (int i = 0; i < start.length; i++) {
			//判断下标i代表的人是否还在
			if (start[i] == 0){
				continue;
			}
			//再选择第二个 
			for (int j = i+1; j < start.length; j++) {
				//判断下标j代表的人是否还在
				if (start[j] ==0) {
					continue;
				}
				//移动i和j去对岸
				int temp = 0;
				//交换两边下标i的数组值
				temp = start[i];
				start[i] = end[i];
				end[i] = temp;
				//同理,交换j
				temp = start[j];
				start[j] = end[j];
				end[j] = temp;
				//当前总步数+1
				step++;
				//时间增加两个人耗时更大的值,注意代表时间的值已经换到了end中
				time += Math.max(end[i],end[j]);
				//判断是否完成过河
				if (step == 7) {
					//完成过河,判断时间是否符合要求
					if (time <= 30) {
						//符合要求,输出解决方案.
						solutionCount++;
						System.out.println("方案"+solutionCount+":");
						System.out.println(solution+addStr(i,j));
						System.out.println("总耗时:"+time+"秒.");
						System.out.println("------------------------------");
					} 					
				} else {				
				//未完成过河,继续执行返回.
				back(solution+addStr(i,j));
				}
				//移动i,j的情况遍历完毕,复原. 
				temp = start[i];
				start[i] = end[i];
				end[i] = temp;
				temp = start[j];
				start[j] = end[j];
				end[j] = temp;
				step--;
				time -= Math.max(start[i],start[j]);
				}
		}
	}
	

	//返回一步
	public static void back (String solution){
		//尝试移动一个人返回
		for (int i = 0; i < end.length; i++) {
			//判断下标i代表的人是否还在
			if (end[i] == 0){
				continue;
			}
			//移动i返回
			int temp = 0;
			//交换两边下标i的数组值
			temp = start[i];
			start[i] = end[i];
			end[i] = temp;
			step++;
			time += start[i];
			//继续下一次过河
			go(solution+addStr(i));
			//复原
			//交换两边下标i的数组值
			temp = start[i];
			start[i] = end[i];
			end[i] = temp;
			step--;
			time -= end[i];
			}
	}
	
	//过河步骤字符串

	private static String addStr(int i, int j) {
		String str;
		//获得过河的两个人的名字
		String goPerson1;
		String goPerson2;
		switch (i) {
		case 0:
			goPerson1="小明";
			break;
		case 1:
			goPerson1="姐姐";
			break;
		case 2:
			goPerson1="弟弟";
			break;
		case 3:
			goPerson1="奶奶";
			break;
		default :
			goPerson1="爷爷";
			break;
		}
		switch (j) {
		case 0:
			goPerson2="小明";
			break;
		case 1:
			goPerson2="姐姐";
			break;
		case 2:
			goPerson2="弟弟";
			break;
		case 3:
			goPerson2="奶奶";
			break;
		default :
			goPerson2="爷爷";
			break;
		}
		str = "\n" + goPerson1 + "和" + goPerson2 + "过河,耗时" + Math.max(end[i],end[j]) + "秒";
		return str;
	}
	//返回步骤字符串
	
	private static String addStr(int i) {
		String str;
		//获得返回的人的名字
		String backPerson;
		switch (i) {
		case 0:
			backPerson="小明";
			break;
		case 1:
			backPerson="姐姐";
			break;
		case 2:
			backPerson="弟弟";
			break;
		case 3:
			backPerson="奶奶";
			break;
		default :
			backPerson="爷爷";
			break;
		}		
		str ="\n" + backPerson + "返回,耗时" + start[i] + "秒.";
		return str;
	}

}
