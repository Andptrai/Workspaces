#include <bits/stdc++.h>
using namespace std;
int main()
{
	int a[10]={1,10,9,5,2,3,4,6,8,7};
	int pivot=a[0];
	int storeIndex =pivot;
	for(int i=pivot;i<10;i++)
	{
		if(a[i]<=a[pivot])
		{
			swap(a[i],pivot); ++storeIndex;
		}
		swap(pivot,storeIndex-1);
		cout<<a[i];
	}

	return 0;
}
