package p007b.p008a.p009a;

import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.GuildVideoAtCapacityBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.a.m, reason: use source file name */
/* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildVideoAtCapacityDialog extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f405j = {outline.m846d0(GuildVideoAtCapacityDialog.class, "binding", "getBinding()Lcom/discord/databinding/GuildVideoAtCapacityBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.m$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m140a(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            new GuildVideoAtCapacityDialog().show(fragmentManager, GuildVideoAtCapacityDialog.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: b.a.a.m$b */
    /* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, GuildVideoAtCapacityBinding> {

        /* JADX INFO: renamed from: j */
        public static final b f408j = new b();

        public b() {
            super(1, GuildVideoAtCapacityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildVideoAtCapacityBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public GuildVideoAtCapacityBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.guild_video_at_capacity_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.guild_video_at_capacity_confirm);
            if (materialButton != null) {
                i = C5419R.id.notice_header_container;
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.notice_header_container);
                if (linearLayout != null) {
                    return new GuildVideoAtCapacityBinding((LinearLayout) view2, materialButton, linearLayout);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.m$c */
    /* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildVideoAtCapacityDialog.this.dismiss();
        }
    }

    public GuildVideoAtCapacityDialog() {
        super(C5419R.layout.guild_video_at_capacity);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.f408j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        ((GuildVideoAtCapacityBinding) this.binding.getValue((Fragment) this, f405j[0])).f1432b.setOnClickListener(new c());
    }
}
