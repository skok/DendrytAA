package com.dendrytdev.org.client.problemSubmiting;

import com.dendrytdev.org.client.bean.Product;

interface IProblemSubmiting {
	void updateProductList(Product[] arr);
	void clearProblemDescription();
}