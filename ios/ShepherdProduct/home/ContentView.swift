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
    
    @State var switchBool : Bool = true
    var body: some View {
        NavigationView{
            
            
            VStack{
                
//                if viewModel.result.code {
//                    Text("true!!!")
//                    NavigationLink(destination:   BadDataView(),isActive: $switchBool){
//
//                    }
//
//                }
                
                Image("icon_main")
                    .resizable()
                    .frame(width: 200, height: 200)
                    .padding(.bottom, 30)
                

                Text("허위/과대 광고 검색")
                    .font(.system(size: 25))
                    .fontWeight(.bold)
                    .foregroundColor(Color.orange)
                
                if viewModel.searching{
                    ProgressView(value: /*@START_MENU_TOKEN@*/0.5/*@END_MENU_TOKEN@*/)
                        .progressViewStyle(CircularProgressViewStyle(tint: Color.orange))
                        
                }
              
                
                HStack{
                    TextField("검색어를 입력 하시오", text: $inputText)
                        .frame(width: 200, height: 35)
    //                    .border(Color.orange)
    //                    .padding(0)
                        
                  
                    Button(action: {
                        print("click")
                        //let searchText:String = inputText
                        let searchText:String = "건강"
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
                
                NavigationLink(destination: {
                    
                    if (viewModel.result.code == true){
                        
                        BadDataView()
                    }
                    else{
                        //BadDataView()
                    }
                    
                }){
                    Text("test click")
                }
                
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
            .navigationTitle("메인 화면")
            .navigationBarHidden(true)
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
