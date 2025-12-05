package p007b.p008a.p062y;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.views.OAuthPermissionViews;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.OauthTokenPermissionListItemBinding;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: OAuthPermissionViews.kt */
/* renamed from: b.a.y.h, reason: use source file name */
/* loaded from: classes2.dex */
public final class OAuthPermissionViews2 extends Lambda implements Function2<LayoutInflater, ViewGroup, OAuthPermissionViews.C7080a> {

    /* renamed from: j */
    public static final OAuthPermissionViews2 f2026j = new OAuthPermissionViews2();

    public OAuthPermissionViews2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public OAuthPermissionViews.C7080a invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        Intrinsics3.checkNotNullParameter(layoutInflater2, "inflater");
        Intrinsics3.checkNotNullParameter(viewGroup2, "parent");
        View viewInflate = layoutInflater2.inflate(C5419R.layout.oauth_token_permission_list_item, viewGroup2, false);
        Objects.requireNonNull(viewInflate, "rootView");
        OauthTokenPermissionListItemBinding oauthTokenPermissionListItemBinding = new OauthTokenPermissionListItemBinding((TextView) viewInflate);
        Intrinsics3.checkNotNullExpressionValue(oauthTokenPermissionListItemBinding, "OauthTokenPermissionList…(inflater, parent, false)");
        return new OAuthPermissionViews.C7080a(oauthTokenPermissionListItemBinding);
    }
}
