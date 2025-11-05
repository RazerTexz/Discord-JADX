package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: GuildVideoAtCapacityDialog.kt */
/* loaded from: classes.dex */
public final class m extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(m.class, "binding", "getBinding()Lcom/discord/databinding/GuildVideoAtCapacityBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: GuildVideoAtCapacityDialog.kt */
    /* renamed from: b.a.a.m$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(FragmentManager fragmentManager) {
            d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
            new m().show(fragmentManager, m.class.getSimpleName());
        }
    }

    /* compiled from: GuildVideoAtCapacityDialog.kt */
    public static final /* synthetic */ class b extends d0.z.d.k implements Function1<View, b.a.i.z> {
        public static final b j = new b();

        public b() {
            super(1, b.a.i.z.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildVideoAtCapacityBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public b.a.i.z invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.guild_video_at_capacity_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.guild_video_at_capacity_confirm);
            if (materialButton != null) {
                i = R.id.notice_header_container;
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                if (linearLayout != null) {
                    return new b.a.i.z((LinearLayout) view2, materialButton, linearLayout);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: GuildVideoAtCapacityDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            m.this.dismiss();
        }
    }

    public m() {
        super(R.layout.guild_video_at_capacity);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        ((b.a.i.z) this.binding.getValue((Fragment) this, j[0])).f238b.setOnClickListener(new c());
    }
}
