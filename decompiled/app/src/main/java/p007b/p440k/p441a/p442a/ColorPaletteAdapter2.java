package p007b.p440k.p441a.p442a;

import android.view.View;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import p007b.p440k.p441a.p442a.ColorPaletteAdapter;

/* compiled from: ColorPaletteAdapter.java */
/* renamed from: b.k.a.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public class ColorPaletteAdapter2 implements View.OnClickListener {

    /* renamed from: j */
    public final /* synthetic */ int f13614j;

    /* renamed from: k */
    public final /* synthetic */ ColorPaletteAdapter.b f13615k;

    public ColorPaletteAdapter2(ColorPaletteAdapter.b bVar, int i) {
        this.f13615k = bVar;
        this.f13614j = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ColorPaletteAdapter colorPaletteAdapter = ColorPaletteAdapter.this;
        int i = colorPaletteAdapter.f13607l;
        int i2 = this.f13614j;
        if (i != i2) {
            colorPaletteAdapter.f13607l = i2;
            colorPaletteAdapter.notifyDataSetChanged();
        }
        ColorPaletteAdapter colorPaletteAdapter2 = ColorPaletteAdapter.this;
        ColorPaletteAdapter.a aVar = colorPaletteAdapter2.f13605j;
        int i3 = colorPaletteAdapter2.f13606k[this.f13614j];
        ColorPickerDialog.C11160h c11160h = (ColorPickerDialog.C11160h) aVar;
        ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
        int i4 = colorPickerDialog.f21723o;
        if (i4 == i3) {
            ColorPickerDialog.m9267g(colorPickerDialog, i4);
            ColorPickerDialog.this.dismiss();
        } else {
            colorPickerDialog.f21723o = i3;
            if (colorPickerDialog.f21726r) {
                colorPickerDialog.m9268h(i3);
            }
        }
    }
}
