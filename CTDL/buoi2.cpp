#include <iostream>
using namespace std;
#define ll long long
int Mod(ll a,ll b,ll c){
    ll s=0;
    while (b>1){
        if (b&1)
            s=(s+a)%c;
        a=(a<<1)%c;
        b=b>>1;
    }
    return (a+s)%c;
}
int Mul(ll a,ll b,ll c){
    ll s=1;
    while (b>1){
        if(b&1)
            s=s*a%c;
        a=Mod(a,a,c);
        b=b>>1;
    }
    return a*s%c;
}
int main()
{
    ll a,b;
    cout<<"nhap a,b: ";
    cin>>a>>b;
    cout<< Mul(a,b,1000);
    return 0;
}
