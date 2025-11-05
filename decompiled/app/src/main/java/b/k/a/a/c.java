package b.k.a.a;

import android.view.View;
import b.k.a.a.b;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;

/* compiled from: ColorPaletteAdapter.java */
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ b.C0161b k;

    public c(b.C0161b c0161b, int i) {
        this.k = c0161b;
        this.j = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = b.this;
        int i = bVar.l;
        int i2 = this.j;
        if (i != i2) {
            bVar.l = i2;
            bVar.notifyDataSetChanged();
        }
        b bVar2 = b.this;
        b.a aVar = bVar2.j;
        int i3 = bVar2.k[this.j];
        ColorPickerDialog.h hVar = (ColorPickerDialog.h) aVar;
        ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
        int i4 = colorPickerDialog.o;
        if (i4 == i3) {
            ColorPickerDialog.g(colorPickerDialog, i4);
            ColorPickerDialog.this.dismiss();
        } else {
            colorPickerDialog.o = i3;
            if (colorPickerDialog.r) {
                colorPickerDialog.h(i3);
            }
        }
    }
}
