//
//  ContentView.swift
//  ShepherdProduct
//
//  Created by k4keye on 2022/02/25.
//

import SwiftUI

struct ContentView: View {
    
    
    @StateObject var viewModel = MainViewModel()
    
    @State var inputText : String = ""
    @State var comToggle : Bool = true
    @State var proToggle : Bool = false
    @State var search_button : Bool = false
    
    var body: some View {
        VStack{
            Image("icon_main")
                .resizable()
                .frame(width: 200, height: 200)
                .padding(.bottom, 30)
            
            
            Text("허위/과대 광고 검색")
                .font(.system(size: 25))
                .fontWeight(.bold)
                .foregroundColor(Color.orange)
                
            HStack{
                TextField("검색어를 입력 하시오", text: $inputText)
                    .frame(width: 200, height: 35)
//                    .border(Color.orange)
//                    .padding(0)
                    
                    
                Button(action: {
                    print("click")
                    let searchText:String = inputText
                    let searchType: SearchType = comToggle ? SearchType.Company : SearchType.Product
                    
                    viewModel.search(searchText: searchText, searchType: searchType)
                }){
                    Image(systemName: "magnifyingglass")
                        .frame(width: 30, height: 35)
                        .background(Color.orange)
                }
            }
//            .overlay{
//                Circle().stroke(lineWidth: 3)
//                    .foregroundColor(Color.orange)
//            }
            .border(Color.orange, width: 3)
            .cornerRadius(5)
            
            VStack{
                Toggle(isOn: $comToggle) {
                    Text("회사명")
                }.onChange(of: comToggle){ value in
                    proToggle = !value
                }
                .tint(.orange) //토글 버튼 색 변경
                Toggle(isOn: $proToggle) {
                    Text("제품명")
                }.onChange(of: proToggle){ value in
                    comToggle = !value
                    
                }
                .tint(.orange) //토글 버튼 색 변경
            }.padding()
           
            
           

        }
        .padding(EdgeInsets(top: 0, leading: 50, bottom: 0, trailing: 50))
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
