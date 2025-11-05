package b.k.a.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.R;

/* compiled from: ColorPaletteAdapter.java */
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public final a j;
    public final int[] k;
    public int l;
    public int m;

    /* compiled from: ColorPaletteAdapter.java */
    public interface a {
    }

    /* compiled from: ColorPaletteAdapter.java */
    /* renamed from: b.k.a.a.b$b, reason: collision with other inner class name */
    public final class C0161b {
        public View a;

        /* renamed from: b, reason: collision with root package name */
        public ColorPanelView f1899b;
        public ImageView c;
        public int d;

        public C0161b(Context context) {
            View viewInflate = View.inflate(context, b.this.m == 0 ? R.d.cpv_color_item_square : R.d.cpv_color_item_circle, null);
            this.a = viewInflate;
            this.f1899b = (ColorPanelView) viewInflate.findViewById(R.c.cpv_color_panel_view);
            this.c = (ImageView) this.a.findViewById(R.c.cpv_color_image_view);
            this.d = this.f1899b.getBorderColor();
            this.a.setTag(this);
        }
    }

    public b(a aVar, int[] iArr, int i, int i2) {
        this.j = aVar;
        this.k = iArr;
        this.l = i;
        this.m = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.k.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(this.k[i]);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0161b c0161b;
        if (view == null) {
            c0161b = new C0161b(viewGroup.getContext());
            view2 = c0161b.a;
        } else {
            view2 = view;
            c0161b = (C0161b) view.getTag();
        }
        int i2 = b.this.k[i];
        int iAlpha = Color.alpha(i2);
        c0161b.f1899b.setColor(i2);
        c0161b.c.setImageResource(b.this.l == i ? R.b.cpv_preset_checked : 0);
        if (iAlpha == 255) {
            b bVar = b.this;
            if (i != bVar.l || ColorUtils.calculateLuminance(bVar.k[i]) < 0.65d) {
                c0161b.c.setColorFilter((ColorFilter) null);
            } else {
                c0161b.c.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
            }
        } else if (iAlpha <= 165) {
            c0161b.f1899b.setBorderColor(i2 | ViewCompat.MEASURED_STATE_MASK);
            c0161b.c.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
        } else {
            c0161b.f1899b.setBorderColor(c0161b.d);
            c0161b.c.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        }
        c0161b.f1899b.setOnClickListener(new c(c0161b, i));
        c0161b.f1899b.setOnLongClickListener(new d(c0161b));
        return view2;
    }
}
