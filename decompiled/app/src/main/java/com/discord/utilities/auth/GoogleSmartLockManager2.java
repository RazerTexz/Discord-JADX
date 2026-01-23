package com.discord.utilities.auth;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.api.ResolvableApiException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: com.discord.utilities.auth.GoogleSmartLockManager$resolveResult$notice$1, reason: use source file name */
/* JADX INFO: compiled from: GoogleSmartLockManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockManager2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ ResolvableApiException $rae;
    public final /* synthetic */ GoogleSmartLockManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleSmartLockManager2(GoogleSmartLockManager googleSmartLockManager, ResolvableApiException resolvableApiException) {
        super(1);
        this.this$0 = googleSmartLockManager;
        this.$rae = resolvableApiException;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Object next;
        Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics3.checkNotNullExpressionValue(fragments, "activity.supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (_Collections.contains(GoogleSmartLockManager.access$getResolvableFragments$p(this.this$0), Reflection2.getOrCreateKotlinClass(((Fragment) next).getClass()))) {
                break;
            }
        }
        Fragment fragment = (Fragment) next;
        if (fragment == null) {
            return true;
        }
        GoogleSmartLockManager.access$resolveResult(this.this$0, fragment, GoogleSmartLockManager.GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE, this.$rae);
        return true;
    }
}
