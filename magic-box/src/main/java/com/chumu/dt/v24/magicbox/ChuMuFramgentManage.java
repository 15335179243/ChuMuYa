package com.chumu.dt.v24.magicbox;

import android.os.Bundle;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ChuMuFramgentManage {

    public static void addFragment(FragmentManager manager, Class<? extends Fragment> tClass, int layoutId){
        addFragment(manager,tClass,layoutId,null,false);
    }

    public static void addFragment(FragmentManager manager, Class<? extends Fragment> tClass, int layoutId, Bundle bundle){
        addFragment(manager,tClass,layoutId,bundle,false);
    }

    public static void addFragment(FragmentManager manager, Class<? extends Fragment> tClass, int layoutId, Bundle bundle,boolean isNeedToBackStack){

        String tag = tClass.getName();//获取当前全类名

        Fragment fragment = manager.findFragmentByTag(tag);//通过Tag获取对应的Fragment对象
        FragmentTransaction transaction = manager.beginTransaction();//开启事务

        //判断fragment是否为空
        if (fragment == null){//为空：创建对象添加到容器显示

            try {
                fragment = tClass.newInstance();//通过反射创建对象

                fragment.setArguments(bundle);//传递数据

                transaction.add(layoutId,fragment,tag);//添加到容器显示当前fragment
                hideOtherFragment(manager,transaction,fragment);//隐藏其他fragment

                if (isNeedToBackStack){//是否需要添加回退栈
                    transaction.addToBackStack(tag);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }else {//对象不为空：继续判断是否添加

            //判断fragment是否被添加
            if (fragment.isAdded()){//添加：判断是否被隐藏

                //判断是否被隐藏
                if (fragment.isHidden()){//隐藏：显示

                    fragment.setArguments(bundle);//传递数据

                    transaction.show(fragment);//显示
                    hideOtherFragment(manager,transaction,fragment);//隐藏其他
                }

            }else {//没添加：添加显示

                fragment.setArguments(bundle);//传递数据

                transaction.add(layoutId,fragment,tag);//添加显示
                hideOtherFragment(manager,transaction,fragment);//隐藏其他

            }
        }


        transaction.commit();
    }

    private static void hideOtherFragment(FragmentManager manager, FragmentTransaction transaction, Fragment willShowFragment) {
        List<Fragment> fragments = manager.getFragments();//获取管理器中所有的fragments
        for (Fragment fragment: fragments) {//循环隐藏
            if (fragment != willShowFragment && !fragment.isHidden()){
                transaction.hide(fragment);
            }
        }
    }
}
