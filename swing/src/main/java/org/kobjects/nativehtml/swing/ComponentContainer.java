package org.kobjects.nativehtml.swing;


import org.kobjects.nativehtml.dom.Document;
import org.kobjects.nativehtml.dom.Element;
import org.kobjects.nativehtml.dom.ElementType;
import org.kobjects.nativehtml.dom.HtmlCollection;
import org.kobjects.nativehtml.layout.BlockLayout;
import org.kobjects.nativehtml.layout.Layout;

public class ComponentContainer extends AbstractHtmlComponent implements HtmlCollection {

	Layout layout = new BlockLayout();
	
	public ComponentContainer(Document document, String elementName) {
		super(document, elementName);
		setLayout(new LayoutAdapter(layout));
	}

	@Override
	public ElementType getElementType() {
		return ElementType.COMPONENT_CONTAINER;
	}

	@Override
	public HtmlCollection getChildren() {
		return this;
	}

	@Override
	public int getLength() {
		return getComponentCount();
	}

	@Override
	public Element item(int index) {
		return (Element) getComponent(index);
	}

	@Override
	public int getIntrinsicMinimumBorderBoxWidth() {
		return getMinimumSize().width;
	}

	@Override
	public int getIntrinsicBorderBoxHeightForWidth(int width) {
		int[] result = new int[2];
		layout.layout(this, 0, 0, width, true, result);
		return result[1];
	}

}