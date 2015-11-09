package container.draw.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import container.draw.Point;
import container.draw.Primitive;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Text extends Primitive
{

    private String text;
    private Point pos;
    private String font;
    private String align;
    private String textStyle;


    public String getText()
    {
        return text;
    }

    public Text setText(String text)
    {
        this.text = text;
        return this;
    }

    public Point getPos()
    {
        return pos;
    }

    public Text setPos(Point pos)
    {
        this.pos = pos;
        return this;
    }

    public String getFont()
    {
        return font;
    }

    public Text setFont(String font)
    {
        this.font = font;
        return this;
    }

    public String getAlign()
    {
        return align;
    }

    public Text setAlign(String align)
    {
        this.align = align;
        return this;
    }

    public String getTextStyle()
    {
        return textStyle;
    }

    public Text setTextStyle(String textStyle)
    {
        this.textStyle = textStyle;
        return this;
    }

    @Override
    public String toString()
    {
        return "Text{" +
                "text='" + text + '\'' +
                ", pos=" + pos +
                ", font='" + font + '\'' +
                ", align='" + align + '\'' +
                ", textStyle='" + textStyle + '\'' +
                '}';
    }
}
