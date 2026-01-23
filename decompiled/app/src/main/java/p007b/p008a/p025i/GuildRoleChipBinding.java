package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.roles.RoleIconView;

/* JADX INFO: renamed from: b.a.i.y, reason: use source file name */
/* JADX INFO: compiled from: GuildRoleChipBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class GuildRoleChipBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f1388a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f1389b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RoleIconView f1390c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1391d;

    public GuildRoleChipBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull RoleIconView roleIconView, @NonNull TextView textView) {
        this.f1388a = cardView;
        this.f1389b = imageView;
        this.f1390c = roleIconView;
        this.f1391d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1388a;
    }
}
